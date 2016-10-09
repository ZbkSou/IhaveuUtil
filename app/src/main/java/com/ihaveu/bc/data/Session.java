package com.ihaveu.bc.data;

/**
 * Created by bc on 16/10/9.
 * Describe
 */
public class Session {

  /**
   * session_key : db61adfc389de2a0d11c0cee5a8ce409
   * secret : f1MCCSZPTCLLEBZe8ZG/K4mMZJNb1nCjlFdwL0T5ldE=
   * current_time : 2016-10-09 10:55:34
   * current_user : 538783
   * is_cookie_supported : false
   * code : bjq7
   */

  private String session_key;
  private String secret;
  private String current_time;
  private String current_user;
  private boolean is_cookie_supported;
  private String code;

  public String getSession_key() {
    return session_key;
  }

  public void setSession_key(String session_key) {
    this.session_key = session_key;
  }

  public String getSecret() {
    return secret;
  }

  public void setSecret(String secret) {
    this.secret = secret;
  }

  public String getCurrent_time() {
    return current_time;
  }

  public void setCurrent_time(String current_time) {
    this.current_time = current_time;
  }

  public String getCurrent_user() {
    return current_user;
  }

  public void setCurrent_user(String current_user) {
    this.current_user = current_user;
  }

  public boolean isIs_cookie_supported() {
    return is_cookie_supported;
  }

  public void setIs_cookie_supported(boolean is_cookie_supported) {
    this.is_cookie_supported = is_cookie_supported;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }
}
