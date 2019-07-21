package id.icon.testing.base;

public interface BasePresenter <V> {
    void onAttach(V view);
    void onDetach();

}