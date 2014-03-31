500px_fandroid_sdk
==================

New 500px Android SDK based on official 500px Android SDK and inspired by flicker Android SDK. To get support, please post your issue in issue section or mail to me at kiumiu.ca@gmail.com.

Features
==================
(1) Thread safe end node operation.
<br>(2) All response from HTTP Get are processed parsed and encapsulated in specific response data structure classes.
<br>(3) Instead of making raw http_get, http_post.... function call, you can find at least one function in this SDK that can perform a specific 500px end node function call.
<br>(4) Full javadoc available.

To use it
==================
(1) Get access token first by using (If you need to access authentication required features)
<br><b>XAuth500pxTask task = new XAuth500pxTask()

(2) After access token is obtained, create a PxApi instance like below
<br><b>PxApi api = new PxApi(token, consumerKey, consumerSecret);

(3) Then to access specific function in specific end node, get a node interface first. For exmaple, to get photo end node interface
<br><b>photoInterface photo = api.getPhotoInterface();

(4) To access specific function, for example, in photo end node. End node function call is thread safe.
<br><b>JSONObject ret = photo.get_photo_id(.......);

Notes
==================
Although I tried my best to encapuslate JSON reponse in this SDK, due to the fact that 500px API is constantly upadting, so if you find the response content is less than what 500px server actually returned, you can use no Ex suffix version function to get full response return.
