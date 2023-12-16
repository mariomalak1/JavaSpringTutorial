package com.Facebook.FaceBookRest.CustomErrors;

public class NotFoundEntity extends Exception{
    String error;

    public NotFoundEntity(String mes){
        error = mes;
    }

    @Override
    public String getMessage() {
        return error;
    }

    @Override
    public void printStackTrace() {
        super.printStackTrace();
    }
}
