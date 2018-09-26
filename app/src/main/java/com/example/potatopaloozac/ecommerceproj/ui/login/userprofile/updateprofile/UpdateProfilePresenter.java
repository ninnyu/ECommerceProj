package com.example.potatopaloozac.ecommerceproj.ui.login.userprofile.updateprofile;

import com.example.potatopaloozac.ecommerceproj.data.DataManager;
import com.example.potatopaloozac.ecommerceproj.data.IDataManager;
import com.example.potatopaloozac.ecommerceproj.data.network.model.UserProfile;

import java.util.regex.Pattern;

public class UpdateProfilePresenter implements IUpdateProfilePresenter, IDataManager.OnProfileUpdateListener {

    private IDataManager dataManager;
    private IUpdateProfileView updateProfileView;

    public UpdateProfilePresenter(UpdateProfileActivity activity) {
        this.dataManager = new DataManager(activity);
        updateProfileView = activity;
    }

    @Override
    public void onActivityCreated() {

    }

    @Override
    public void onUpdateButtonClicked(UserProfile profile) {
        if (validate(profile)) {
            dataManager.updateProfile(this, profile);
        } else {
            updateProfileView.showInvalid();
        }
    }

    @Override
    public void updateProfile(boolean isUpdated) {
        updateProfileView.showUpdate(isUpdated);
    }

    public boolean validate(UserProfile profile) {
        Pattern pattern_user = Pattern.compile("^[a-zA-Z]{4,20}$"),
                pattern_address = Pattern.compile("[\\w',-.\\s]+"),
                pattern_email = Pattern.compile("^[a-zA-z0-9_-]+(\\.[a-zA-z0-9_-]+)*@[a-zA-z0-9_-]+(\\.[a-zA-z0-9]+)*(\\.[a-zA-z]{2,})$"),
                pattern_mobile = Pattern.compile("[0-9]{10}");

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

        return true;
    }
}
