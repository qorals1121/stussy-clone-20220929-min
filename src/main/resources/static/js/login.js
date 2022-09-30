const registerButton = document.querySelector(".login-button")[0];
const loginButton = document.querySelector(".login-button")[1];

registerButton.onclick = () => {
    location.href= "/account/register";
}

loginButton.onclick = () => {
    const loginForm = document.querySelector("form");
    loginForm.submit();
}