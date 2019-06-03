package com.example.saar;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    TextView achievementsText;
    Spinner spinnerEmployment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        //setting back button in toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        achievementsText = (TextView) findViewById(R.id.achievements_text);
        makeTextViewResizable(achievementsText, 3, "...View More", true);

        String employmentTypeArray[] = {"Salaried", "Entrepreneur", "Higher Studies", "Civil Services"};

        //TODO To be changed
        /*String employmentType = "Salaried";
        int position = 0, i;
        for (i = 0; i <= employmentTypeArray.length; i++) {
            if (employmentType.equals(employmentTypeArray[i])) {
                position = i;
                break;
            }
        }
        for (i = position; i >= 1; i--) {
            employmentTypeArray[i] = employmentTypeArray[i - 1];
        }
        employmentTypeArray[0] = employmentType;*/

        spinnerEmployment = (Spinner) findViewById(R.id.spinner_profile_employment);

        ArrayAdapter<String> spinnerEmploymentArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, employmentTypeArray);
        spinnerEmploymentArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerEmployment.setAdapter(spinnerEmploymentArrayAdapter);

        spinnerEmployment.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        final Button saveButton = (Button) findViewById(R.id.profile_save_button);

        //find the Edit options
        TextView emailChange = (TextView) findViewById(R.id.email_change);
        TextView passwordChange = (TextView) findViewById(R.id.password_change);
        TextView contactChange = (TextView) findViewById(R.id.contact_change);
        TextView employerChange = (TextView) findViewById(R.id.present_employer_change);
        TextView designationChange = (TextView) findViewById(R.id.designation_change);
        TextView addressChange = (TextView) findViewById(R.id.address_change);
        TextView countryChange = (TextView) findViewById(R.id.country_change);
        TextView stateChange = (TextView) findViewById(R.id.state_change);
        TextView cityChange = (TextView) findViewById(R.id.city_change);
        TextView achievementsChange = (TextView) findViewById(R.id.achievements_change);

        final RelativeLayout emailLayout = (RelativeLayout) findViewById(R.id.email_value);
        final RelativeLayout passwordLayout = (RelativeLayout) findViewById(R.id.password_value);
        final RelativeLayout contactLayout = (RelativeLayout) findViewById(R.id.contact_value);
        final RelativeLayout employerLayout = (RelativeLayout) findViewById(R.id.present_employer_value);
        final RelativeLayout designationLayout = (RelativeLayout) findViewById(R.id.designation_value);
        final RelativeLayout addressLayout = (RelativeLayout) findViewById(R.id.address_value);
        final RelativeLayout countryLayout = (RelativeLayout) findViewById(R.id.country_value);
        final RelativeLayout stateLayout = (RelativeLayout) findViewById(R.id.state_value);
        final RelativeLayout cityLayout = (RelativeLayout) findViewById(R.id.city_value);
        final RelativeLayout achievementsLayout = (RelativeLayout) findViewById(R.id.achievements_value);

        //find edittext fields
        final EditText emailEdit = (EditText) findViewById(R.id.edit_email_profile);
        final LinearLayout passwordEdit = (LinearLayout) findViewById(R.id.edit_password_profile);
        final EditText passwordEditNew = (EditText) findViewById(R.id.edit_password_profile_new);
        final EditText contactEdit = (EditText) findViewById(R.id.edit_contact_profile);
        final EditText employerEdit = (EditText) findViewById(R.id.edit_present_employer_profile);
        final EditText designationEdit = (EditText) findViewById(R.id.edit_designation_profile);
        final EditText addressEdit = (EditText) findViewById(R.id.edit_address_profile);
        final EditText countryEdit = (EditText) findViewById(R.id.edit_country_profile);
        final EditText stateEdit = (EditText) findViewById(R.id.edit_state_profile);
        final EditText cityEdit = (EditText) findViewById(R.id.edit_city_profile);
        final EditText achievementsEdit = (EditText) findViewById(R.id.edit_achievements_profile);

        final TextView emailNew = (TextView) findViewById(R.id.email_text);
        final TextView passwordNew = (TextView) findViewById(R.id.password_text);
        final TextView contactNew = (TextView) findViewById(R.id.contact_text);
        final TextView employerNew = (TextView) findViewById(R.id.present_employer_text);
        final TextView designationNew = (TextView) findViewById(R.id.designation_text);
        final TextView addressNew = (TextView) findViewById(R.id.address_text);
        final TextView countryNew = (TextView) findViewById(R.id.country_text);
        final TextView stateNew = (TextView) findViewById(R.id.state_text);
        final TextView cityNew = (TextView) findViewById(R.id.city_text);


        emailChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emailLayout.setVisibility(View.INVISIBLE);
                emailEdit.setVisibility(View.VISIBLE);
                saveButton.setVisibility(View.VISIBLE);
            }
        });
        passwordChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passwordLayout.setVisibility(View.INVISIBLE);
                passwordEdit.setVisibility(View.VISIBLE);
                saveButton.setVisibility(View.VISIBLE);
            }
        });
        contactChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contactLayout.setVisibility(View.INVISIBLE);
                contactEdit.setVisibility(View.VISIBLE);
                saveButton.setVisibility(View.VISIBLE);
            }
        });
        employerChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                employerLayout.setVisibility(View.INVISIBLE);
                employerEdit.setVisibility(View.VISIBLE);
                saveButton.setVisibility(View.VISIBLE);
            }
        });
        designationChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                designationLayout.setVisibility(View.INVISIBLE);
                designationEdit.setVisibility(View.VISIBLE);
                saveButton.setVisibility(View.VISIBLE);
            }
        });
        addressChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addressLayout.setVisibility(View.INVISIBLE);
                addressEdit.setVisibility(View.VISIBLE);
                saveButton.setVisibility(View.VISIBLE);
            }
        });
        countryChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countryLayout.setVisibility(View.INVISIBLE);
                countryEdit.setVisibility(View.VISIBLE);
                saveButton.setVisibility(View.VISIBLE);
            }
        });
        stateChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stateLayout.setVisibility(View.INVISIBLE);
                stateEdit.setVisibility(View.VISIBLE);
                saveButton.setVisibility(View.VISIBLE);
            }
        });
        cityChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cityLayout.setVisibility(View.INVISIBLE);
                cityEdit.setVisibility(View.VISIBLE);
                saveButton.setVisibility(View.VISIBLE);
            }
        });
        achievementsChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                achievementsLayout.setVisibility(View.INVISIBLE);
                achievementsEdit.setVisibility(View.VISIBLE);
                saveButton.setVisibility(View.VISIBLE);
            }
        });
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = emailEdit.getText().toString();
                String password = passwordEditNew.getText().toString();
                String contact = contactEdit.getText().toString();
                String employer = employerEdit.getText().toString();
                String designation = designationEdit.getText().toString();
                String address = addressEdit.getText().toString();
                String country = countryEdit.getText().toString();
                String state = stateEdit.getText().toString();
                String city = cityEdit.getText().toString();
                String achievements = achievementsEdit.getText().toString();

                if (!email.matches("") && email.indexOf(0) != ' ')
                    emailNew.setText(email);

                //TODO check old password entered is correct or not
                passwordNew.setText(password);
                if (!contact.matches("") && contact.indexOf(0) != ' ')
                    contactNew.setText(contact);
                if (!employer.matches("") && employer.indexOf(0) != ' ')
                    employerNew.setText(employer);
                if (!designation.matches("") && designation.indexOf(0) != ' ')
                    designationNew.setText(designation);
                if (!address.matches("") && address.indexOf(0) != ' ')
                    addressNew.setText(address);
                if (!country.matches("") && country.indexOf(0) != ' ')
                    countryNew.setText(country);
                if (!state.matches("") && state.indexOf(0) != ' ')
                    stateNew.setText(state);
                if (!city.matches("") && city.indexOf(0) != ' ')
                    cityNew.setText(city);
                achievementsText.setText(achievements);

                emailLayout.setVisibility(View.VISIBLE);
                emailEdit.setVisibility(View.INVISIBLE);

                passwordLayout.setVisibility(View.VISIBLE);
                passwordEdit.setVisibility(View.INVISIBLE);

                contactLayout.setVisibility(View.VISIBLE);
                contactEdit.setVisibility(View.INVISIBLE);

                employerLayout.setVisibility(View.VISIBLE);
                employerEdit.setVisibility(View.INVISIBLE);

                designationLayout.setVisibility(View.VISIBLE);
                designationEdit.setVisibility(View.INVISIBLE);

                addressLayout.setVisibility(View.VISIBLE);
                addressEdit.setVisibility(View.INVISIBLE);

                countryLayout.setVisibility(View.VISIBLE);
                countryEdit.setVisibility(View.INVISIBLE);

                stateLayout.setVisibility(View.VISIBLE);
                stateEdit.setVisibility(View.INVISIBLE);

                cityLayout.setVisibility(View.VISIBLE);
                cityEdit.setVisibility(View.INVISIBLE);

                achievementsLayout.setVisibility(View.VISIBLE);
                achievementsEdit.setVisibility(View.INVISIBLE);

                saveButton.setVisibility(View.GONE);

            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        //handle back button action
        onBackPressed();
        return true;
    }


    public static void makeTextViewResizable(final TextView tv, final int maxLine, final String expandText, final boolean viewMore) {

        if (tv.getTag() == null) {
            tv.setTag(tv.getText());
        }
        ViewTreeObserver vto = tv.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {

            @SuppressWarnings("deprecation")
            @Override
            public void onGlobalLayout() {

                ViewTreeObserver obs = tv.getViewTreeObserver();
                obs.removeGlobalOnLayoutListener(this);
                if (maxLine == 0) {
                    int lineEndIndex = tv.getLayout().getLineEnd(0);
                    String text = tv.getText().subSequence(0, lineEndIndex - expandText.length() + 1) + " " + expandText;
                    tv.setText(text);
                    tv.setMovementMethod(LinkMovementMethod.getInstance());
                    tv.setText(
                            addClickablePartTextViewResizable(Html.fromHtml(tv.getText().toString()), tv, maxLine, expandText,
                                    viewMore), TextView.BufferType.SPANNABLE);
                } else if (maxLine > 0 && tv.getLineCount() >= maxLine) {
                    int lineEndIndex = tv.getLayout().getLineEnd(maxLine - 1);
                    String text = tv.getText().subSequence(0, lineEndIndex - expandText.length() + 1) + " " + expandText;
                    tv.setText(text);
                    tv.setMovementMethod(LinkMovementMethod.getInstance());
                    tv.setText(
                            addClickablePartTextViewResizable(Html.fromHtml(tv.getText().toString()), tv, maxLine, expandText,
                                    viewMore), TextView.BufferType.SPANNABLE);
                } else {
                    int lineEndIndex = tv.getLayout().getLineEnd(tv.getLayout().getLineCount() - 1);
                    String text = tv.getText().subSequence(0, lineEndIndex) + " " + expandText;
                    tv.setText(text);
                    tv.setMovementMethod(LinkMovementMethod.getInstance());
                    tv.setText(
                            addClickablePartTextViewResizable(Html.fromHtml(tv.getText().toString()), tv, lineEndIndex, expandText,
                                    viewMore), TextView.BufferType.SPANNABLE);
                }
            }
        });

    }

    private static SpannableStringBuilder addClickablePartTextViewResizable(final Spanned strSpanned, final TextView tv, final int maxLine, final String spanableText, final boolean viewMore) {
        String str = strSpanned.toString();
        SpannableStringBuilder ssb = new SpannableStringBuilder(strSpanned);

        if (str.contains(spanableText)) {


            ssb.setSpan(new MySpannable(false) {
                @Override
                public void onClick(View widget) {
                    if (viewMore) {
                        tv.setLayoutParams(tv.getLayoutParams());
                        tv.setText(tv.getTag().toString(), TextView.BufferType.SPANNABLE);
                        tv.invalidate();
                        makeTextViewResizable(tv, -1, "View Less", false);
                    } else {
                        tv.setLayoutParams(tv.getLayoutParams());
                        tv.setText(tv.getTag().toString(), TextView.BufferType.SPANNABLE);
                        tv.invalidate();
                        makeTextViewResizable(tv, 3, "...View More", true);
                    }
                }
            }, str.indexOf(spanableText), str.indexOf(spanableText) + spanableText.length(), 0);

        }
        return ssb;
    }
}

