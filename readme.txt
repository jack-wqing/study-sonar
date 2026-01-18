1、扫描命令:/Users/tyc/work-tools/sonar-scanner-7.3.0.5189-macosx-aarch64/bin/sonar-scanner -Dsonar.projectKey=study-sonar -Dsonar.sources=src -Dsonar.java.binaries=target/classes -Dsonar.host.url=http://localhost:9000 -Dsonar.token=sqa_abbc06b280ac8033f6780c16269e07b6400b6fce
2、SCA客户端和服务端配置一直，不然会有解析告警
3、依赖脚本: dependency-check.sh  --project study-sonar --scan target/study-sonar-1.0-SNAPSHOT.jar --format JSON --out target

