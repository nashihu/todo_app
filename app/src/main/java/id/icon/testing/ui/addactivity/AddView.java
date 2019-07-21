package id.icon.testing.ui.addactivity;

import id.icon.testing.base.BaseView;

public interface AddView extends BaseView {
    void requestProcess();
    void requestFinish();
    void requestMessage(String message);
}
