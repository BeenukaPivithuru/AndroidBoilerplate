package com.nisala.androidboilerplate.util;

import android.content.Context;
import android.text.TextUtils;

import com.nisala.androidboilerplate.R;

/**
 * Created by nisala on 12,October,2018
 */
public class AndroidBoilerplateHelper {
    public static String getErrorMessage(Context context, int errorCode) {
        String message = null;
        switch (errorCode) {
            case 402:
                message = context.getString(R.string.error_invalid_api_key);
                break;
            case 403:
                message = context.getString(R.string.error_user_name_exist);
                break;
            case 406:
                message = context.getString(R.string.error_email_exist);
                break;
            case 456:
                message = context.getString(R.string.error_credential_not_match);
                break;
            case 417:
                message = context.getString(R.string.error_invalid_password);
                break;
            case 418:
                message = context.getString(R.string.error_unkown);
                break;
            case 421:
                message = context.getString(R.string.error_data_not_found);
                break;
            case 423:
                message = context.getString(R.string.error_data_not_found);
                break;
            case 424:
                message = context.getString(R.string.error_user_not_found);
                break;
            case 427:
                message = context.getString(R.string.error_invalid_password);
                break;
            case 428:
                message = context.getString(R.string.error_email_not_match);
                break;
            case 429:
                message = context.getString(R.string.error_email_exist);
                break;
            case 500:
                message = context.getString(R.string.error_internal_server);
                break;
            case 404:
                message = context.getString(R.string.error_user_not_found);
                break;

            default:
                break;
        }
        return message;
    }

    public final static boolean isValidEmailAddress(String email) {
        if (TextUtils.isEmpty(email)) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
        }
    }
}

