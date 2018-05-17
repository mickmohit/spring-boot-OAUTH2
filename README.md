# spring-boot-OAUTH2
spring-boot-OAUTH2


1. create Entities User and Role.
2. controller with end points.

3. create authorisation server
--override method 
 1. impliment security constraints on token endpoints with "isAuthenticated" which is true for non-anonymous user.
 2. ClientDetailsService --intialize client details with client id
 3. defines authorization and token end points and token service with implementing authenticationManager.
 
4. create resource server 
which servers resources that are protected by oauth2
---override method --http security for secure rest end point, which will be accessed when only authenticated.

5. As by default grant type are not supported for password then you need implement your own authenticationManager which you already did above. Autowire authenticationManager in
 your main class

6.So now you need use userDetailsService service from AuthenticationManagerBuilder to find user by its name in repository you built. But userDetailsService wont understand
 your repository.findByUsername() because it want userdetails not user which we provided, so then you need to write your own custom CustomUserDetails service which will extend UserDetails by default. This service class will get details
 from your entity User.
 
7. You can create the user from main class and create and service for encodinng the password and save it.
 
8.  from postman, with POST request
 http://localhost:8080/oauth/token?grant_type=password&username=user&password=user
 
 then access the secure end point. http://localhost:8080/asd?access_token=5b7bc8c6-74ec-46e1-b7ad-28f462301c83
