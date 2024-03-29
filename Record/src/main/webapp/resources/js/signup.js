
const checkobj = {
    "inputId" : false, 
    "inputPw" : false, 
    "inputPwConfirm" : false, 
    "inputName" : false 
};

console.log("signup. js loaded.");


const inputId = document.getElementById("inputId");

inputId.addEventListener("change", function(){ 
    const regExp = /^[a-z][\w!@#$%^&*_-]{5,13}$/;  
  

    if(regExp.test(this.value)){
        console.log("asd");
    this.style.backgroundColor = "lightgreen";
    this.style.color = "white";
    checkobj.inputId = true;
    } else{
        this.style.backgroundColor = "black";
        this.style.color = "white";
        checkobj.inputId = false;
    }

}); 


    const inputPw = document.getElementById("inputPw");
    const inputPwConfirm = document.getElementById("inputPw2");

    inputPwConfirm.addEventListener("keyup", function() {

        if(inputPw.value.length == 0){
            this.value = "";
            alert("비밀번호를 먼저 입력해주세요");
            inputPw.focus();  
            checkobj.inputPw = false;
        }
    });

    const pwMessage = document.getElementById("pwMessage");

    inputPw.addEventListener("keyup",function() {

        if( (inputPw.value == inputPwConfirm.value ) && inputPw.value.length != 0 ){
            pwMessage.innerText = "비밀번호 일치";
            pwMessage.classList.add("confirm");
            pwMessage.classList.remove("error");
            checkobj.inputPw = true;
            checkobj.inputPwConfirm = true;
        }else{
            pwMessage.innerText = "비밀번호 불일치";
            pwMessage.classList.add("error");
            pwMessage.classList.remove("confirm");
            checkobj.inputPwConfirm = false;
        }

    });


    inputPwConfirm.addEventListener("keyup",function() {

        if( (inputPw.value == inputPwConfirm.value ) && inputPw.value.length != 0 ){
            pwMessage.innerText = "비밀번호 일치";
            pwMessage.classList.add("confirm");
            pwMessage.classList.remove("error");
            checkobj.inputPw = true;
            checkobj.inputPwConfirm = true;
        }else{
            pwMessage.innerText = "비밀번호 불일치";
            pwMessage.classList.add("error");
            pwMessage.classList.remove("confirm");
            checkobj.inputPwConfirm = false;
        }

    });


   const inputName = document.getElementById("inputName");

   inputName.addEventListener("change", function() {
       const regExp = /^[가-힣]{2,5}$/; 
       
       const nameMessage = document.getElementById("nameMessage");

       if(regExp.test(this.value)){
            nameMessage.innerText = "정상입력";
            nameMessage.classList.add("confirm");
            nameMessage.classList.remove("error");
            checkobj.inputName = true;
       }else{
        nameMessage.innerText = "2글자에서 5글자 사이 한글만 입력해주세요";
        nameMessage.classList.add("error");
        nameMessage.classList.remove("confirm");
        checkobj.inputName = false;
       }
      


   });



function validate() {

    for(let key in checkobj){
        if( !checkobj[key] ){ 
            alert("유효성 검사가 완료되지 않았습니다.");
            return false;
        }
    }
    return true;
}




