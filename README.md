# Laboratorio06
En este repositorio tenemos el desarrollo de la práctica de laboratorio N°6. Donde ponemos en práctica los conceptos de control de versiones.
El Autor 1: David Useche
El Autor 2: Daniela Sepúlveda

Terminamos!
Integración contínua con CircleCI y Heroku

Documentación CircleCI para Heroku:
Parte I.

    Retome el proyecto Web desarrollado en el laboratorio antepasado (la herramientade registro de consultas a pacientes), e integre en el mismo el esquema de DAOs del laboratorio pasado. Recuerde que además de los fuentes, debe incorporar las dependencias y demás 'plugins' que se estén usando en el POM.xml de este último.

    Haga una nueva clase que implemente la interfaz "ServiciosPacientes", pero que a diferencia de la disponible actualmente (ServiciosPacientesStub), maneje un esquema de persistencia real, a través del esquema de DAOs implementado.

    Actualice los cambios realizados en su repositorio de GitHUB.

Parte II.

    Cree (si no la tiene aún) una cuenta en el proveedor PAAS Heroku (www.heroku.com).

    Acceda a su cuenta en Heroku y cree una nueva aplicación:

    Después de crear su cuenta en Heroku y la respectiva aplicación, genere una llave de API: Opción Manage Account:

    Opción API Key:

    Ingrese a la plataforma de integración contínua Circle.CI (www.circleci.com). Para ingresar, basta que se autentique con su usuario de GitHUB.

    Ingrese a las opciones generales de su cuenta y registre la llave de Heroku. Con esto, CircleCI tendrá privilegios para hacer despliegue automático.

    Conecte su aplicación (la desarrollada en la parte I) con el ambiente de integración contínua. Abra la opción de 'agregar proyecto':

    Seleccione el proyecto de la parte I, y seleccione 'build project'.

    En CircleCI, seleccione el proyecto recién agregado, abra su menú de opciones y seleccione las opciones de despliegue de Heroku:

    Verifique que ya esté registrada la llave del API. Luego, asocie el 'usuario de despliegue' (Step 2):

    Si todo queda correctamente configurado, cada vez que hagan un PUSH al repositorio, CircleCI ejecutará la fase de construcción del proyecto. Para que cuando las pruebas pasen automáticamente se despliegue en Heroku, deben definir en el archivo circle.yml (ubicado en la raíz del proyecto):
        La rama del repositorio de GitHUB que se desplegará en Heroku. o El nombre de la aplicación de Heroku en la que se hará el despliegue.
        La ejecución de la fase ‘site’ de Maven, para generar la documentación de pruebas, cubrimiento de pruebas y análisis estático (cuando las mismas sean habilitadas).

    Ejemplo: https://github.com/PDSW-ECI/base-proyectos/blob/master/circle.yml

    Rectifique que en el pom.xml, en la fase de construcción, se tenga el siguiente plugin (es decir, dentro de ):

    <!-- Plugin configuration for Heroku compatibility. -->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-dependency-plugin</artifactId>
                <version>2.1</version>
                <executions>
                    <execution>
                        <phase>package</phase>
                        <goals>
                            <goal>copy</goal>
                        </goals>
                        <configuration>
                            <artifactItems>
                                <artifactItem>
                                    <groupId>com.github.jsimone</groupId>
                                    <artifactId>webapp-runner</artifactId>
                                    <version>8.0.30.2</version>
                                    <destFileName>webapp-runner.jar</destFileName>
                                </artifactItem>
                            </artifactItems>

                        </configuration>
                    </execution>

                </executions>
            </plugin>

    Nota: Si en el pom.xml ya hay otro plugin con el mismo y , reemplácelo por el anteriormente mostrado.

    Heroku requiere los siguientes archivos de configuración (con sus respectivos contenidos) en el directorio raíz del proyecto, de manera que sea qué versión de Java utilizar, y cómo iniciar la aplicación, respectivamente:

    system.properties

    java.runtime.version=1.8

    Procfile

    web:    java $JAVA_OPTS -jar target/dependency/webapp-runner.jar --port $PORT target/*.war

    El ambiente de despliegue contínuo requiere también un archivo de configuración 'circle.yml' en la raíz del proyecto, en el cual se indica (entre otras cosas) en qué aplicación de Heroku se debe desplegar la aplicación que está en GitHUB. Puede basarse en el siguiente archivo, teniendo en cuenta que se debe ajustar el parámetro 'appname': https://github.com/PDSW-ECI/base-proyectos/blob/master/circle.yml

    Haga commit y push de su repositorio local a GitHub. Abra la consola de CircleCI y verifique que el de descarga, compilación, y despliegue. Igualmente, verifique que la aplicación haya sido desplegada en Heroku.


