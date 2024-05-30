document.getElementById("userForm").addEventListener("submit", function(event) {
  event.preventDefault();

  let name = document.getElementById("name").value;
  let email = document.getElementById("email").value;
  let age = parseInt(document.getElementById("age").value);

  if (!validateEmail(email)) {
    alert("Invalid email format. Please enter a valid email address.");
    return;
  }

  user.changeName(name);
  user.updateEmail(email);
  user.age = age;

  alert("User details updated successfully!");
});

function validateEmail(email) {
  const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
  return emailRegex.test(email);
}

let user = {
  name: "Sharmila Yoha Malar",
  email: "sym@0410.com",
  age: 23,
  // Function to change the name
  changeName: function(newName) {
    this.name = newName;
  },
  // Function to update the email
  updateEmail: function(newEmail) {
    if (validateEmail(newEmail)) {
      this.email = newEmail;
    } else {
      console.log("Invalid email format. Please enter a valid email address.");
    }
  },
  // Function to calculate birth year
  calculateBirthYear: function() {
    let currentYear = new Date().getFullYear();
    return currentYear - this.age;
  }
};