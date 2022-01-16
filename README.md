# springboot-google-oauth2

The solution implies leveraging the Google’s OAuth2 support. If you remember in the OAuth2 flow diagram we have an Authorization Server and a Resource Server. In our case Google will be the Authorization Server responsible of handling user authentication and generating access tokens and our backend will be the Resource Server responsible of validating the access tokens against Google and allowing our users to create, read, update or delete

![Scheme](images/oauth2.png)
