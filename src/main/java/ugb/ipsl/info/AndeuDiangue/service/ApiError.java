package ugb.ipsl.info.AndeuDiangue.service;

public class ApiError extends RuntimeException {
  public ApiError(String message) {
    super(message);
  }
}
