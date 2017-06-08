package com.saidozcan.kiraz.Models;

import java.util.HashMap;

/**
 * Created by mozcan on 22/05/2017.
 */
public class ValidationResult {
    private boolean isValid;
    private String validationErrorMessage;

    public boolean isValid() {
        return isValid;
    }

    public String getValidationErrorMessage() {
        return validationErrorMessage;
    }

    public ValidationResult(boolean isValid, String validationErrorMessage) {
        this.isValid = isValid;
        this.validationErrorMessage = validationErrorMessage;
    }
}
