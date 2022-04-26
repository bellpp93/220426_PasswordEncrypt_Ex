import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/*
 * [중요] 패스워드를 암호화 시키기
 */
public class PasswordEncryptUtil {
	public static void main(String[] args) {
		// 패스워드 값
		String plainText = "test1234";  // 평문(plainText)
		String sha256 = "";
		
		try {
			MessageDigest mdSHA256 = MessageDigest.getInstance("SHA-256");
			mdSHA256.update(plainText.getBytes("UTF-8"));
			
			byte[] sha256Hash = mdSHA256.digest();
			StringBuffer hexSHA256hash = new StringBuffer();
			
			for(byte b : sha256Hash) {
				String hexString = String.format("%02x", b);  // 16진수는 x 8진수는 o
				hexSHA256hash.append(hexString);  // 16진수로 64자리
			}
			sha256 = hexSHA256hash.toString();
			
		} catch (NoSuchAlgorithmException e) {e.printStackTrace();
		} catch (UnsupportedEncodingException e) {e.printStackTrace();
		}
		System.out.println(sha256);
		// 937e8d5fbb48bd4949536cd65b8d35c426b80d2f830c5c308e2cdec422ae2244
	}
}
