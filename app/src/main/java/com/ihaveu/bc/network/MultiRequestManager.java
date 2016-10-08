package com.ihaveu.bc.network;

import java.util.ArrayList;

/**
 * Created by bc on 16/9/30.
 * Describe
 * 多个请求管理
 * 处理多个请求全部完成后执行一些操作
 */
public class MultiRequestManager {
  private final String TAG = "MultiRequestManager";
  private ArrayList<MultiRequest> mRequests;
  private boolean mIsReady = false;
  private IOnReady mOnReadyHandler;

  public MultiRequestManager() {
    mRequests = new ArrayList<MultiRequest>();
  }

  public MultiRequestManager(IOnReady handler) {
    mRequests = new ArrayList<MultiRequest>();
    mOnReadyHandler = handler;
  }

  public void attach(final MultiRequest request) {
    request.setOnReadyHandler(new IOnReady() {
      @Override
      public void onReady(int id, MultiRequest.RequestState state) {
        if (mOnReadyHandler != null) {

          MultiRequest.RequestState s = MultiRequest.RequestState.DEFAULT;

          for (MultiRequest r : mRequests) {
            //如果有Default 没有Ready
            if (r.getState().equals(MultiRequest.RequestState.DEFAULT)) {
              return;
              // 如果其中一个Error 返回Error
            } else if (r.getState().equals(MultiRequest.RequestState.ERROR)) {
              mIsReady = true;
              mOnReadyHandler.onReady(id, MultiRequest.RequestState.ERROR);
              return;
            }
          }
          // 否则认为所有都成功返回
          mIsReady = true;
          mOnReadyHandler.onReady(id, MultiRequest.RequestState.SUCCESS);
        }
      }
    });
    mRequests.add(request);
  }

  public boolean dettach(final MultiRequest request) {
    return mRequests.remove(request);
  }

  public void setOnReadyHandler(IOnReady handler) {
    mOnReadyHandler = handler;
  }

  public void clear() {
    mRequests.clear();
  }

  public int size() {
    return mRequests.size();
  }

  public interface IOnReady {
    public void onReady(int id, MultiRequest.RequestState state);
  }

  public boolean isReady() {
    return mIsReady;
  }
}
