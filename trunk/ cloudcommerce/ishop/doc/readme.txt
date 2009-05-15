1. The software needed

 a. Tomcat
 b. GWT
 c. ANT
 d. MySQL

2. How to create tables

Edit core\src\WEB-INF\applicationContext.xml. Change line 

  <prop key="hibernate.hbm2ddl.auto">validates</prop>
 
to 
 
  <prop key="hibernate.hbm2ddl.auto">create</prop>
  
Then run class 
 core\test\com\jcommerce\core\dao\GoodsDAOTest.java
  
The tables will be created. When done, you should undo file applicationContext.xml.  

3. How to run GWT

Run web\iShop-shell.cmd to launch GWT

4. How to use build\build.xml

Running ant without argument will print the usable arguments.

We use Tomcat as test environment. Please config tomcat in file build.properties and start tomcat before execute "deploy" command.

File build.properties defines the tomcat parameters and JCOMMERCE_HOME.

5. How to access to font end page

Use http://localhost:8080/dispatch.do?page=home to access front end page. The port is tomcat's port. 