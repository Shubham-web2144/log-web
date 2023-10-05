console.log("Hello");
var quill1 = new Quill('#editor1', {
    theme: 'snow'
});



const form1= document.querySelector('#f1');
let editorContent1 = document.querySelector('#editor-content1');

form1.onsubmit = (e) => {
    editorContent1.value = JSON.stringify(quill1.getContents());
}

