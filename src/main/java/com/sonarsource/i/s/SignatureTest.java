package com.sonarsource.i.s;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 无法获取私钥信息
 */
public class SignatureTest {

    static final String 꿳 = "*";
    private static final byte[] 橵 = new byte[]{48, -126, 1, -72, 48, -126, 1, 44, 6, 7, 42, -122, 72, -50, 56, 4, 1, 48, -126, 1, 31, 2, -127, -127, 0, -3, 127, 83, -127, 29, 117, 18, 41, 82, -33, 74, -100, 46, -20, -28, -25, -10, 17, -73, 82, 60, -17, 68, 0, -61, 30, 63, -128, -74, 81, 38, 105, 69, 93, 64, 34, 81, -5, 89, 61, -115, 88, -6, -65, -59, -11, -70, 48, -10, -53, -101, 85, 108, -41, -127, 59, -128, 29, 52, 111, -14, 102, 96, -73, 107, -103, 80, -91, -92, -97, -97, -24, 4, 123, 16, 34, -62, 79, -69, -87, -41, -2, -73, -58, 27, -8, 59, 87, -25, -58, -88, -90, 21, 15, 4, -5, -125, -10, -45, -59, 30, -61, 2, 53, 84, 19, 90, 22, -111, 50, -10, 117, -13, -82, 43, 97, -41, 42, -17, -14, 34, 3, 25, -99, -47, 72, 1, -57, 2, 21, 0, -105, 96, 80, -113, 21, 35, 11, -52, -78, -110, -71, -126, -94, -21, -124, 11, -16, 88, 28, -11, 2, -127, -127, 0, -9, -31, -96, -123, -42, -101, 61, -34, -53, -68, -85, 92, 54, -72, 87, -71, 121, -108, -81, -69, -6, 58, -22, -126, -7, 87, 76, 11, 61, 7, -126, 103, 81, 89, 87, -114, -70, -44, 89, 79, -26, 113};
    private static final byte[] 騍 = new byte[]{7, 16, -127, -128, -76, 73, 22, 113, 35, -24, 76, 40, 22, 19, -73, -49, 9, 50, -116, -56, -90, -31, 60, 22, 122, -117, 84, 124, -115, 40, -32, -93, -82, 30, 43, -77, -90, 117, -111, 110, -93, 127, 11, -6, 33, 53, 98, -15, -5, 98, 122, 1, 36, 59, -52, -92, -15, -66, -88, 81, -112, -119, -88, -125, -33, -31, 90, -27, -97, 6, -110, -117, 102, 94, -128, 123, 85, 37, 100, 1, 76, 59, -2, -49, 73, 42, 3, -127, -123, 0, 2, -127, -127, 0, -101, 37, -53, 3, 90, 12, -10, -58, 107, 49, -49, -78, 58, 64, 42, 62, -9, 17, -67, 59, -107, 3, -45, 104, -32, 25, 45, -117, 103, 73, 16, 66, -28, -52, -123, -52, -28, -21, -45, -69, 2, -68, -44, 92, 80, -40, 14, 88, -88, -91, 104, 112, -76, 47, 97, 2, -7, -103, -105, -4, 2, -24, -22, -49, -118, -128, -35, -92, 39, -95, 104, 103, -91, 78, 85, -121, 25, 1, 75, -122, -70, 87, 118, -51, -58, -86, 89, -22, 28, 21, -31, 103, 101, -106, 74, -95, 66, -126, -94, -38, 20, 95, 97, -113, 97, -70, 90, 102, -71, 45, -17, -95, -27, 35, 64, -86, 49, -101, 36, 118, -7, 108, 111, -30, 89, 109, -6, 108};
    private static final byte[] 犡 = new byte[]{48, -126, 2, 34, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 1, 5, 0, 3, -126, 2, 15, 0, 48, -126, 2, 10, 2, -126, 2, 1, 0, -114, -49, 42, 85, 110, -104, 104, -34, 123, 112, 65, -45, 113, 45, 31, 52, 71, 117, 3, 94, -63, -35, -34, -93, -36, 103, -92, 97, -113, -31, -114, 6, 68, 60, 95, 116, -80, -55, 67, -92, -44, 34, 96, -97, 35, -72, -44, 58, 71, 42, 123, 55, -55, -77, -31, 73, 44, -9, 80, 9, -35, -38, -74, 57, -89, 122, 112, -39, 105, 72, 116, -61, -83, -9, -52, -37, 25, 123, 22, -112, -29, -69, 84, -111, -48, 79, 87, -117, -119, -8, -68, -53, 7, -64, 124, -99, 8, -28, 83, -3, -19, -99, -35, 98, -47, -41, -35, 42, 29, -122, 121, -43, 64, -118, -96, 100, -103, -114, 119, 121, 30, -84, 81, 93, -4, 48, 75, 12, 6, -19, 2, 116, -91, -75, -44, -51, -42, 94, -51, -34, 55, 55, -127, -20, 113, -100, -6, -106, 28, 31, -102, -35, 53, -117, -85, -5, -38, 126, 85, 27, -39, -10, 59, -104, -37, -71, 99, 117, -113, 73, -19, -86, 47, 50, -67, -79, -91, -40, -119, 44, 8, 125, 113, 14, -117, -21, -3, 3, 26, 110, 120, 42, 12, -107, 57, 14, -113, 85, -15, -122, 1, -14, -91, 50, -12, -115, -63, 124, 76, -56, 109, -11, -86, 92, 100, -86, 117, 18, -112, -75, -121, 18, 79, 75, 44, -72, 62, -89, -59, -67, -18, -73, -28, 40, 98, 107, 38, 125, -49, -47, 22, -12, -38, 36, 32, 63, -3, 24, -25, 44};
    private static final byte[] 世 = new byte[]{-126, -28, 77, -78, -57, -17, 83, 0, 57, 119, 43, -93, -84, 58, 48, -56, 94, 32, 65, -82, 8, 46, -112, -34, -12, -62, -29, 60, 40, 61, -27, -28, -68, -24, -104, 127, -59, 59, 9, -93, -81, -123, -90, -110, 65, -69, 112, 31, 78, 21, 93, -127, -27, -74, 79, -65, 99, -37, -19, 92, -51, -95, 81, 109, 13, 76, 103, -108, 54, -65, -2, 106, 89, -113, -81, 110, -12, 5, -18, -93, -86, -103, 112, 13, -51, 16, 101, 67, 9, -10, 24, -71, -85, -10, -76, 100, 103, -81, 89, 53, -85, -77, -82, 69, -50, 75, 77, -4, -3, 72, -102, -78, -77, -107, -33, 74, 80, -13, -32, -93, 79, 47, -123, 64, -89, -46, 5, 66, -72, 74, -58, -122, -24, 57, 40, -33, -81, -117, 40, -95, 58, -16, -113, -82, 98, 35, -7, -70, 109, -124, -28, 5, -71, -53, -77, -7, 74, -127, 0, 97, 46, -78, -1, -107, 29, 64, 95, 63, 45, 33, 70, 46, -53, -80, 41, 68, 63, 98, -79, 34, -23, -15, -4, -7, -22, -8, 29, -22, 19, 15, -12, 40, -81, -34, -115, -21, 50, -51, 110, -92, 24, -44, -62, -56, -34, 11, 44, -104, -52, 18, 74, 84, 88, 122, 73, 87, 101, 72, 107, 20, -44, 63, 102, 55, -40, -7, 40, 29, 28, 95, 3, 25, -36, 99, -99, 23, -61, 8, 39, -112, 0, -24, 85, 77, 105, -39, 115, 46, 46, -44, -39, 64, -1, -103, 107, -59, -62, -16, -95, 40, 73, 119, 2, 3, 1, 0, 1};

    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, SignatureException {

        String digest = "";
        byte[] var3 = Base64.decodeBase64(digest.getBytes(StandardCharsets.UTF_8));
        String var4 = 댫();
        String var5 = (new ATest(new long[]{-6122372896554399424L, 5041288841332736282L})).toString();
        KeyFactory var6 = KeyFactory.getInstance(var5);
        PublicKey var7 = var6.generatePublic(new X509EncodedKeySpec(꿳()));
        String var8 = (new ATest(new long[]{8250305852132372687L, 4860574071230314498L, -3615289328406187023L})).toString();
        Signature var9 = Signature.getInstance(var8);
        var9.initVerify(var7);
        var9.update(var4.getBytes(StandardCharsets.UTF_8));
        boolean var10 = var9.verify(var3);

    }

    public static byte[] 꿳() {
        return 꿳(橵, 騍);
    }

    public static byte[] 殔() {
        return 꿳(犡, 世);
    }


    static byte[] 꿳(byte[] var0, byte[] var1) {
        byte[] var2 = new byte[var0.length + var1.length];
        System.arraycopy(var0, 0, var2, 0, var0.length);
        System.arraycopy(var1, 0, var2, var0.length, var1.length);
        return var2;
    }

    public static String 댫() {

        String plugins = "license,branch,developer,enterprise,governance,apex,abap,cpp,plsql,swift,tsql,vbnet,cobol,pli,rpg,vb,go,python,php,java,datacenter-edition,ce-workers,developer-scanner,developer-server,ha,securityreport,monitoring,scim,gitlab-vulnerability-report,analysis-icu,analysis-kuromoji,analysis-nori,analysis-phonetic,analysis-smartcn,analysis-stempel,analysis-ukrainian,discovery-azure-classic,discovery-ec2,discovery-gce,ingest-attachment,mapper-annotated-text,mapper-murmur3,mapper-size,repository-azure,repository-gcs,repository-hdfs,repository-s3,store-smb,transport-nio,cayc,cfamily,csharp,dbd-java-frontend,dbd,dbd-python-frontend,flex,html,iac,jacoco,javascript,kotlin,ruby,scala,security-csharp-frontend,security-java-frontend,security-js-frontend,security-php-frontend,security,security-python-frontend,text-enterprise,text,xml,architecture-java-frontend,architecture,cfamily-dependencies,csharp-enterprise,dart,iac-enterprise,java-symbolic-execution,jcl,vbnet-enterprise,architecture-javascript-frontend,go-enterprise,jasmin,rust,security-go-frontend,security-vbnet-frontend,text-enterprise,sca,advanced-security";
        List<String> pluginArray = Arrays.asList(StringUtils.split(plugins, ","));

        String feature = "Vulnerability Analysis,High Availability,Analysis of APEX,Analysis of Java,Analysis of JavaScript,Analysis of C#,Analysis of TypeScript,Analysis of Flex,Analysis of Python,Analysis of PHP,Analysis of XML,Analysis of Web,Branch Analysis,SonarLint Smart Notifications,Portfolios Management,Executive Reporting,Project Transfer,Parallel Processing,Analysis of ABAP,Analysis of C/C++,Analysis of Objective-C,Analysis of PL/SQL,Analysis of Swift,Analysis of T-SQL,Analysis of VB.NET,Analysis of COBOL,Analysis of PL/I,Analysis of RPG,Analysis of VB6,Advanced Security,SCA";
        ArrayList<String> var1 = new ArrayList<>();
        var1.add("2099-12-31");
        var1.add("Enterprise");
        var1.add("Enterprise");
        var1.add(String.valueOf(9223372036854775807L));
        var1.addAll(pluginArray);
        var1.add(feature);
        var1.add("AZtQGNXQaTcveFPRSu7j");
        var1.add(String.valueOf(true));
        var1.add("PRODUCTION");
        var1.add("XXXXX");
        return var1.stream().collect(Collectors.joining("|"));
    }

}
