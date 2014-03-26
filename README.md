500px_fandroid_sdk
==================

New 500px Android SDK based on official 500px Android SDK and inspired by flicker Android SDK. This project is still under development and is not finished yet. So use it with your own risk.

Currently, all request returns are returned in JSONObject format. I will, however, design a ready to use Response class for each request later on.



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
