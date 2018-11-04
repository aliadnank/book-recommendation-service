package com.aliadnan.bookrecommendationservice.config;

import com.aliadnan.bookrecommendationservice.util.FeedbackEnum;

import java.beans.PropertyEditorSupport;

/**
 * @author Ali
 * @createdOn 2018/10/28
 */
public class FeedbackTypeEditor extends PropertyEditorSupport {

    public void setAsText(String text) {
        try {
            setValue(FeedbackEnum.valueOf(text.toUpperCase()));
        } catch (Exception ex) {
            setValue(null);
        }
    }
}
