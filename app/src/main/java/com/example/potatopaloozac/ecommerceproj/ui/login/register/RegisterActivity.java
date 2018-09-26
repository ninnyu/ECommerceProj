package com.example.potatopaloozac.ecommerceproj.ui.login.register;

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
import com.example.potatopaloozac.ecommerceproj.ui.login.LoginActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends AppCompatActivity implements IRegisterView {

    private IRegisterPresenter registerPresenter;

    @BindView(R.id.et_registerfname)
    EditText et_fname;
    @BindView(R.id.et_registerlname)
    EditText et_lname;
    @BindView(R.id.tv_userValidation)
    TextView tv_UserValidation;
    @BindView(R.id.et_registeraddress)
    EditText et_address;
    @BindView(R.id.tv_addressValidation)
    TextView tv_AddressValidation;
    @BindView(R.id.et_registeremail)
    EditText et_email;
    @BindView(R.id.tv_emailValidation)
    TextView tv_EmailValidation;
    @BindView(R.id.et_registermobile)
    EditText et_mobile;
    @BindView(R.id.tv_mobileValidation)
    TextView tv_MobileValidation;
    @BindView(R.id.et_registerpassword)
    EditText et_password;
    @BindView(R.id.tv_passwordValidation)
    TextView tv_PasswordValidation;
    @BindView(R.id.bt_register)
    Button bt_Register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);

        registerPresenter = new RegisterPresenter(this);
        registerPresenter.onActivityCreated();
    }

    @Override
    public void showRegister(boolean isSuccess) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        if (isSuccess) {
            alertDialogBuilder.setTitle(R.string.alertRegistrationSuccess);
            alertDialogBuilder.setMessage(R.string.alertRegistrationSuccessMessage);
            alertDialogBuilder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(i);
                }
            });
            alertDialogBuilder.show();
        }
        else {
            alertDialogBuilder.setTitle(R.string.alertRegistrationFailed);
            alertDialogBuilder.setMessage(R.string.alertRegistrationFailedMessage);
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
        tv_UserValidation.setText(getString(R.string.userValidation));
        tv_AddressValidation.setText(getString(R.string.addressValidation));
        tv_EmailValidation.setText(getString(R.string.emailValidation));
        tv_MobileValidation.setText(getString(R.string.mobileValidation));
        tv_PasswordValidation.setText(getString(R.string.passwordValidation));
    }

    @OnClick(R.id.bt_register)
    public void onViewClicked() {
        UserProfile profile = new UserProfile();

        profile.setFname(et_fname.getText().toString());
        profile.setLname(et_lname.getText().toString());
        profile.setAddress(et_address.getText().toString());
        profile.setEmail(et_email.getText().toString());
        profile.setMobile(et_mobile.getText().toString());
        profile.setPassword(et_password.getText().toString());

        registerPresenter.onRegisterButtonClicked(profile);
    }
}
