package com.example.potatopaloozac.ecommerceproj.ui.login.userprofile.updateprofile;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.potatopaloozac.ecommerceproj.R;
import com.example.potatopaloozac.ecommerceproj.data.network.model.UserProfile;
import com.example.potatopaloozac.ecommerceproj.ui.login.userprofile.UserProfileActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UpdateProfileActivity extends AppCompatActivity implements IUpdateProfileView {

    @BindView(R.id.et_updateFname)
    EditText etUpdateFname;
    @BindView(R.id.et_updateLname)
    EditText etUpdateLname;
    @BindView(R.id.tv_updateUserValidation)
    TextView tvUserValidation;
    @BindView(R.id.et_updateAddress)
    EditText etUpdateAddress;
    @BindView(R.id.tv_updateAddressValidation)
    TextView tvAddressValidation;
    @BindView(R.id.et_updateEmail)
    EditText etUpdateEmail;
    @BindView(R.id.tv_updateEmailValidation)
    TextView tvEmailValidation;
    @BindView(R.id.et_updateMobile)
    EditText etUpdateMobile;
    @BindView(R.id.tv_updateMobileValidation)
    TextView tvMobileValidation;
    @BindView(R.id.bt_updateProfile)
    Button btUpdateProfile;

    private IUpdateProfilePresenter updateProfilePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);
        ButterKnife.bind(this);

        updateProfilePresenter = new UpdateProfilePresenter(this);
    }

    @Override
    public void showUpdate(boolean isUpdated) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        if (isUpdated) {
            UserProfileActivity.userProfileActivity.finish();

            alertDialogBuilder.setTitle(R.string.alertUpdateSuccess);
            alertDialogBuilder.setMessage(R.string.alertUpdateSuccessMessage);
            alertDialogBuilder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent i = new Intent(UpdateProfileActivity.this, UserProfileActivity.class);
                    startActivity(i);
                }
            });
            alertDialogBuilder.show();
        }
        else {
            alertDialogBuilder.setTitle(R.string.alertUpdateFailed);
            alertDialogBuilder.setMessage(R.string.alertUpdateFailedMessage);
            alertDialogBuilder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            alertDialogBuilder.show();
        }
    }

    @Override
    public void showInvalid() {
        tvUserValidation.setText(getString(R.string.userValidation));
        tvAddressValidation.setText(getString(R.string.addressValidation));
        tvEmailValidation.setText(getString(R.string.emailValidation));
        tvMobileValidation.setText(getString(R.string.mobileValidation));
    }

    @OnClick(R.id.bt_updateProfile)
    public void onViewClicked() {
        UserProfile profile = new UserProfile();

        profile.setFname(etUpdateFname.getText().toString());
        profile.setLname(etUpdateLname.getText().toString());
        profile.setAddress(etUpdateAddress.getText().toString());
        profile.setEmail(etUpdateEmail.getText().toString());
        profile.setMobile(etUpdateMobile.getText().toString());

        updateProfilePresenter.onUpdateButtonClicked(profile);
    }

}
