package id.icon.testing.ui.editactivity;

import id.icon.testing.base.BaseView;

public interface EditView extends BaseView {
    void requestProcess();
    void requestFinish(String title, String desc, String id);
    void sendMessage(String message);
}
