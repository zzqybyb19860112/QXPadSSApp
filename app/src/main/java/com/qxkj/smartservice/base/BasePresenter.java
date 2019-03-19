package com.qxkj.smartservice.base;

public class BasePresenter {
    protected IBaseView mRequestView;
    protected BaseModel mRequestModel;

    public void detach() {
        mRequestView = null;
    }

    public void interruptHttp() {
        if (mRequestModel != null) {
            mRequestModel.interruptRequest();
        }
    }
}
