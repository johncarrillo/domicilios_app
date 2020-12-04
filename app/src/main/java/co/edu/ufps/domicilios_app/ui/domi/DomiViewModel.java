package co.edu.ufps.domicilios_app.ui.domi;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DomiViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public DomiViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
