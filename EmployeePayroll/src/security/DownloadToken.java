package security;

public class DownloadToken {
 private final long createdTime = System.currentTimeMillis();
 private final long expiryMillis = 60 * 1000; // 1 minute

 public boolean isExpired() {
     return (System.currentTimeMillis() - createdTime) > expiryMillis;
 }
}