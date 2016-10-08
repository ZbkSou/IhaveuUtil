package com.ihaveu.bc.network;

import java.util.ArrayList;

/**
 * Created by bc on 16/9/30.
 * Describe
 */
public class MultiRequestCommon extends MultiRequest implements IModelResponse{
  private IModelResponse mResponse;
  public MultiRequestCommon(IModelResponse response) {
    mResponse = response;
  }
  @Override
  public void onSuccess(Object model, ArrayList list) {

    if(mResponse != null) {
      mResponse.onSuccess(model, list);
    }
    onReady(RequestState.SUCCESS);
  }

  @Override
  public void onError(String msg) {
    if (mResponse != null)
      mResponse.onError(msg);
    onReady(RequestState.ERROR);
  }
}
