package com.example.potatopaloozac.ecommerceproj.ui.login.register;

import com.example.potatopaloozac.ecommerceproj.data.DataManager;
import com.example.potatopaloozac.ecommerceproj.data.IDataManager;
import com.example.potatopaloozac.ecommerceproj.data.network.model.UserProfile;

import java.util.regex.Pattern;

public class RegisterPresenter implements IRegisterPresenter, IDataManager.OnRegisterListener {

    private IDataManager dataManager;
    private IRegisterView registerView;

    public RegisterPresenter (RegisterActivity activity) {
        dataManager = new DataManager(activity);
        registerView = activity;
    }

    @Override
    public void onRegisterButtonClicked(UserProfile profile) {
        if (validate(profile)) {
            dataManager.register(this, profile);
        } else {
            registerView.showInvalid();
        }
    }

    @Override
    public void userRegister(boolean isSuccess) {
        registerView.showRegister(isSuccess);
    }

    public boolean validate(UserProfile profile) {
        Pattern pattern_user = Pattern.compile("^[a-zA-Z]{4,20}$"),
                pattern_address = Pattern.compile("[\\w',-.\\s]+"),
                pattern_email = Pattern.compile("^[a-zA-z0-9_-]+(\\.[a-zA-z0-9_-]+)*@[a-zA-z0-9_-]+(\\.[a-zA-z0-9]+)*(\\.[a-zA-z]{2,})$"),
                pattern_mobile = Pattern.compile("[0-9]{10}"),
                pattern_password = Pattern.compile("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!.#$@_+,?-]).{5,20}");

        if (!pattern_user.matcher(profile.getFname()).matches())
            return false;
        if (!pattern_user.matcher(profile.getLname()).matches())
            return false;
        if (!pattern_address.matcher(profile.getAddress()).matches())
            return false;
        if (!pattern_email.matcher(profile.getEmail()).matches())
            return false;
        if (!pattern_mobile.matcher(profile.getMobile()).matches())
            return false;
        if (!pattern_password.matcher(profile.getPassword()).matches())
            return false;

        return true;
    }
}
