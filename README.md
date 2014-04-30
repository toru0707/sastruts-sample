sastruts-sample
===============

sastrutsを利用したプロジェクトのサンプルを作成

## 環境

java:     1.7.0_25
tomcat:   7.0.42
eclipse:  Kepler(4.3) 
maven:    3.2.1

## インストール

### 1. ArchetypeでのProjectの作成

```
$mvn archetype:generate -DarchetypeRepository=http://maven.seasar.org/maven2/ -DarchetypeGroupId=org.seasar.sastruts -DarchetypeArtifactId=sa-struts-archetype -DarchetypeVersion=1.0.4-sp9.1 -DgroupId=org.toru0707 -DartifactId=sastruts-sample -Dversion=1.0.0-SNAPSHOT
$cd sastruts-sample
$mvn eclipse:eclipse
```

### 2. TomcatPluginのインストール

```
$cd plugins/ && unzip tomcatPluginV33.zip
$mv com.sysdeo.eclipse.tomcat_3.3.0 ${ECLIPSE_HOME}/plugins
```

### 3. Eclipseへのプロジェクトインポート

1. [Import] -> [Import] -> [Existing Maven Project]
2. pom.xmlのエラーをQuickFixで修正
3. [Tomcatプロジェクト] -> [コンテキストの定義を更新]

※MavenのProjectUpdate時に次のエラーが出る場合の対処: An internal error occurred during: "Updating Maven Project". Unsupported IClasspathEntry kind=4

1. rightclick project, remove maven nature (or in newer eclipse, "Maven->Disable Maven Nature")
2. mvn eclipse:clean (with project open in eclipse/STS)
3. delete the project in eclipse (but do not delete the sources)
4. Import existing Maven project
※参考：http://stackoverflow.com/questions/15065093/an-internal-error-occurred-during-updating-maven-project-unsupported-iclassp

### 4. 開発用のプロジェクト設定

#### コンパイルしたJavaクラスを動的にTomcatに読み込むように設定する。

1. [Properties] -> [Tomcat] -> [開発用クラスローダのクラスパス]
2. 以下にチェックする。

```
/sastruts-sample/target/classes
/sastruts-sample/target/test-classes
org.eclipse.m2e.MAVEN2_CLASSPATH_CONTAINER
```

3. DevLoader.jarを${CATALINA_HOME}/lib/以下に配置する。

plugins/tomcatPluginV33.zipに格納されているDevloaderTomcat7.jarをコピーする。

4. pom.xmlから、以下の不要なdependenciesを除外する。

少なくとも以下の2つは除外しないと, ClassCastExceptionが発生する。

```
<dependency>
  <groupId>org.apache.geronimo.specs</groupId>
  <artifactId>geronimo-jsp_2.0_spec</artifactId>
  <version>1.0</version>
  <scope>provided</scope>
</dependency>
<dependency>
  <groupId>org.apache.geronimo.specs</groupId>
  <artifactId>geronimo-servlet_2.4_spec</artifactId>
  <version>1.0</version>
  <scope>provided</scope>
</dependency>
```

5. /src/main/webapp/WEB-INF/classes を削除する

classes/ 以下の設定ファイルが設定ファイルの動的変更を妨げるため削除する
