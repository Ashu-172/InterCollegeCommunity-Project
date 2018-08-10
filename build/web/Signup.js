/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//facebook response
/* global FB, gapi, auth2 */

window.fbAsyncInit = function () {
    var v = 
    FB.init({
        appId: document.getElementById("id").value,
        status: true,
        cookie: true,
        xfbml: true
    });
    FB.AppEvents.logPageView();
};

(function (doc) {
    var js;
    var id = 'facebook-jssdk';
    var ref = doc.getElementsByTagName('script')[0];
    if (doc.getElementById(id)) {
        return;
    }
    js = doc.createElement('script');
    js.id = id;
    js.async = true;
    js.src = "//connect.facebook.net/en_US/all.js";
    ref.parentNode.insertBefore(js, ref);
}(document));

function Login() {
    FB.login(function (response) {
        console.log('API response', response);
        if (response.authResponse) {
            FB.api('/me?fields=id,email,first_name,last_name,name', function (response) {
                document.getElementById("First_name").value = response.first_name;
                document.getElementById("Last_name").value = response.last_name;
                document.getElementById("Email").value = response.email;
                //document.getElementById("profile").setAttribute("src", "http://graph.facebook.com/" + response.id + "/picture?type=normal");
                document.getElementById("PP").value = "http://graph.facebook.com/" + response.id + "/picture?type=large";
                //document.getElementById('FacebookresponseContainer').value = '\n\n Fb Full Response:\n' + JSON.stringify(response);
            });
        } else {
            alert("Login attempt failed!");
        }
    }, {scope: 'email,user_photos,publish_actions'});
    //  FB.api('me/' function(returnData) { } );
}


//Google Response
// This sample assumes a client object has been created.
// To learn more about creating a client, check out the starter:
//  https://developers.google.com/+/quickstart/javascript
gapi.client.load('plus', 'v1', function () {
    var request = gapi.client.plus.people.get({
        'userId': 'me'
    });
    request.execute(function (resp) {
        console.log('Retrieved profile for:' + resp.displayName);
    });
});
/**
 * Handler for the signin callback triggered after the user selects an account.
 */
function onSignInCallback(resp) {
    gapi.client.load('plus', 'v1', apiClientLoaded);
}

/**
 * Sets up an API call after the Google API client loads.
 */
function apiClientLoaded() {
    gapi.client.plus.people.get({userId: 'me'}).execute(handleEmailResponse);
}

/**
 * Response callback for when the API client receives a response.
 *
 * @param resp The API response object with the user email and profile information.
 */
function handleEmailResponse(resp) {
    var primaryEmail;
    for (var i = 0; i < resp.emails.length; i++) {
        if (resp.emails[i].type === 'account')
            primaryEmail = resp.emails[i].value;
    }
    document.getElementById("First_name").value = resp.name.givenName;
    document.getElementById("Last_name").value = resp.name.familyName;
    document.getElementById("Email").value = primaryEmail;
    document.getElementById('PP').value=resp.image.url;
    //document.getElementById('PP').value = 'Primary email: ' +
           // primaryEmail + '\nName: ' + resp.displayName + '\n\n Google Full Response:\n' + JSON.stringify(resp);
}
//password check
var confirmField = document.getElementById("confirm_password");
var passwordField = document.getElementById("password");

var check = function() {
  if (passwordField.value ===confirmField.value) {
    confirmField.style.color = 'green';
} else {
     confirmField.style.color = 'red';
     }
};
