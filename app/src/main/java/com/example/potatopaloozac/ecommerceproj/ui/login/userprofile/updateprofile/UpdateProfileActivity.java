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

    @BindView(R.id.et_registerfname)
    EditText etRegisterfname;
    @BindView(R.id.et_registerlname)
    EditText etRegisterlname;
    @BindView(R.id.tv_userValidation)
    TextView tvUserValidation;
    @BindView(R.id.et_registeraddress)
    EditText etRegisteraddress;
    @BindView(R.id.tv_addressValidation)
    TextView tvAddressValidation;
    @BindView(R.id.et_registeremail)
    EditText etRegisteremail;
    @BindView(R.id.tv_emailValidation)
    TextView tvEmailValidation;
    @BindView(R.id.et_registermobile)
    EditText etRegistermobile;
    @BindView(R.id.tv_mobileValidation)
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

        profile.setFname(etRegisterfname.getText().toString());
        profile.setLname(etRegisterlname.getText().toString());
        profile.setAddress(etRegisteraddress.getText().toString());
        profile.setEmail(etRegisteremail.getText().toString());
        profile.setMobile(etRegistermobile.getText().toString());

        updateProfilePresenter.onUpdateButtonClicked(profile);
    }

}
