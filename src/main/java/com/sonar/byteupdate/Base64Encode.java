package com.sonar.byteupdate;

import org.apache.commons.codec.binary.Base64;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Base64Encode {

    public static void main(String[] args) throws IOException {

        String value = "Company=XXXXX\n" +
                "Digest=XXXXX\n" +
                "Edition=Enterprise\n" +
                "EditionLabel=Enterprise\n" +
                "Expiration=2099-12-31\n" +
                "MaxLoc=9223372036854775807\n" +
                "Plugins=license,branch,developer,enterprise,governance,apex,abap,cpp,plsql,swift,tsql,vbnet,cobol,pli,rpg,vb,go,python,php,java,datacenter-edition,ce-workers,developer-scanner,developer-server,ha,securityreport,monitoring,scim,gitlab-vulnerability-report,analysis-icu,analysis-kuromoji,analysis-nori,analysis-phonetic,analysis-smartcn,analysis-stempel,analysis-ukrainian,discovery-azure-classic,discovery-ec2,discovery-gce,ingest-attachment,mapper-annotated-text,mapper-murmur3,mapper-size,repository-azure,repository-gcs,repository-hdfs,repository-s3,store-smb,transport-nio,cayc,cfamily,csharp,dbd-java-frontend,dbd,dbd-python-frontend,flex,html,iac,jacoco,javascript,kotlin,ruby,scala,security-csharp-frontend,security-java-frontend,security-js-frontend,security-php-frontend,security,security-python-frontend,text-enterprise,text,xml,architecture-java-frontend,architecture,cfamily-dependencies,csharp-enterprise,dart,iac-enterprise,java-symbolic-execution,jcl,vbnet-enterprise,architecture-javascript-frontend,go-enterprise,jasmin,rust,security-go-frontend,security-vbnet-frontend,text-enterprise,sca,advanced-security\n" +
                "Features=Vulnerability Analysis,High Availability,Analysis of APEX,Analysis of Java,Analysis of JavaScript,Analysis of C#,Analysis of TypeScript,Analysis of Flex,Analysis of Python,Analysis of PHP,Analysis of XML,Analysis of Web,Branch Analysis,SonarLint Smart Notifications,Portfolios Management,Executive Reporting,Project Transfer,Parallel Processing,Analysis of ABAP,Analysis of C/C++,Analysis of Objective-C,Analysis of PL/SQL,Analysis of Swift,Analysis of T-SQL,Analysis of VB.NET,Analysis of COBOL,Analysis of PL/I,Analysis of RPG,Analysis of VB6,Advanced Security,SCA\n" +
                "ServerId=*\n" +
                "Support=true\n" +
                "Type=PRODUCTION";

        byte[] bytes = Base64.encodeBase64(value.getBytes());
        System.out.println(new String(bytes));


        String decode = new String(Base64.decodeBase64("eyJsaWNlbnNlVHlwZSI6ICJlbnRlcnByaXNlIiwgImVkaXRpb24iOiAiRW50ZXJwcmlzZSIsICJmZWF0dXJlcyI6IFsiQW5hbHlzaXMiLCAiQ29kZS1TYW5pbHkiXSwgImV4cGlyZXNBdCI6IDE3MzU2ODk2MDAwMDAsICJkZXRhaWxzIjogeyJjb21wYW55IjogIk15Q28iLCAic2VydmVySWQiOiAiQVhYWFhYWFhYIn0sICJzaWduYXR1cmUiOiAiUklTQV9TSUdOQVRVUkVfREFUQSJ9\n".getBytes(StandardCharsets.UTF_8)), StandardCharsets.UTF_8);
        System.out.println(decode);
    }

}
