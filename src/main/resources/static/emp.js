
//get all employees

function showemployee(){
    fetch(`http://localhost:8080/Employee`)
    .then(res=>res.json())
    .then(data=>{
       let rows=""
       data.forEach(emp => {
      rows+=
         `<tr>
            <td>
                ${emp.id}
            </td>
            <td>
                ${emp.name}
            </td>
             <td>
                ${emp.place}
            </td>
            <td>
            <button onclick="updateEmployee(${emp.id},'${emp.name}','${emp.place}')">Update</button>
            </td>
            <td>
            <button onclick="deleteEmployee(${emp.id})">Delete
            </button>

            </td>
         </tr>`
        
       });


        table=document.querySelector("#tabledata tbody").innerHTML=rows;
    })
    .catch(error=>{
        console.error("data fetching error",error)
    })
}
//update
let updateid=null;
function updateEmployee(id,name,place){
document.getElementById("name").value=name
document.getElementById("place").value=place
updateid=id;
}







//delete
function deleteEmployee(id){
if(confirm("are you sure you want delete this employee?")){
    fetch(`http://localhost:8080/Employee/${id}`,{
        method:"DELETE"
    })
    .then(response=>{
    if(response.ok){
        alert("employee deleted succefully")
        showemployee()
    }else{
        alert("employee not deleted")
    }


    })
    .catch(error=>{console.error("error while deleting employee",error)})
}


}







document.getElementById("employee").onsubmit=function(event){

event.preventDefault();

let name=document.getElementById("name").value

let place=document.getElementById("place").value
if(updateid===null){
    fetch("http://localhost:8080/Employee",{
    method:"post",
headers:{"content-type": "application/json"},
body:JSON.stringify({name:name,place:place})
})
.then(response=>response.text())
.then(data=>{
    alert("inserted")
})

}else{
fetch(`http://localhost:8080/Employee/${updateid}`,{
method:"PUT",
headers:{"content-type":"application/json"},
body:JSON.stringify({name:name,place:place})

})
.then(res=>res.text())
.then(data=>{
    alert("employee updated")
    updateid=null
    document.getElementById("employee").reset()
    showemployee()
})




}
}

window.onload=showemployee;