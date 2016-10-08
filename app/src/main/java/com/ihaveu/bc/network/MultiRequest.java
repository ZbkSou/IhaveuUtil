package com.ihaveu.bc.network;

/**
 * Created by bc on 16/9/30.
 * Describe 多任务请求的回调
 */
public class MultiRequest {
  public enum RequestState {
    DEFAULT,
    SUCCESS,
    ERROR
  }

  protected RequestState mState = RequestState.DEFAULT;
  protected MultiRequestManager.IOnReady onReadyHandler;
  protected int mId = 0;
  protected static int pId = 1;


  public static int newId() {
    return pId++;
  }

  public MultiRequest() {
    mId = newId();
  }

  public RequestState getState() {
    return mState;
  }

  /**
   * 供Multi
   * @param handler
   */
  protected void setOnReadyHandler(MultiRequestManager.IOnReady handler) {
    onReadyHandler = handler;
  }

  /**
   * 完成请求
   * @param state
   */
  public void onReady(RequestState state) {
    mState = state;
    if (onReadyHandler != null) onReadyHandler.onReady(mId, state);
  }
}
