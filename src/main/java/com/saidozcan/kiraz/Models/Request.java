package com.saidozcan.kiraz.Models;

/**
 * Created by mozcan on 21/05/2017.
 */
public class Request {
    final static private String wordProcessingModeKey = "word";
    final static private String sentenceProcessingModeKey = "sentence";

    String processingMode;
    String query;

    public String getProcessingMode() {
        return processingMode;
    }

    public void setProcessingMode(String processingMode) {
        this.processingMode = processingMode;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public ProcessingMode getCurrentMode() {
        if (this.isWordMode()) {
            return ProcessingMode.WORD;
        }
        return ProcessingMode.SENTENCE;
    }

    private boolean isWordMode() {
        return this.processingMode.equals(wordProcessingModeKey);
    }

    private boolean isSentenceMode() {
        return this.processingMode.equals(sentenceProcessingModeKey);
    }

    public Request(String processingMode, String query) {
        this.processingMode = processingMode;
        this.query = query;
    }

    public Request() {

    }

    public ValidationResult validate() {
        if (null == this.processingMode || 0 == this.processingMode.length()) {
            return new ValidationResult(false, "processing_mode parameter should not be null.");
        }

        if (null == this.query || 0 == this.query.length()) {
            return new ValidationResult(false, "query parameter should not be null.");
        }

        String[] words = this.query.split(" ");
        if (this.isWordMode() && 1 < words.length) {
            return new ValidationResult(false, "query parameter should be only one word for processing_mode=word");
        }

        if (this.isSentenceMode() && 1 >= words.length) {
            return new ValidationResult(false, "query parameter should be a sentence for processing_mode=sentence");
        }

        return new ValidationResult(true, null);
    }
}
