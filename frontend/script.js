// Base URL (Spring Boot backend)
const BASE_URL = "http://localhost:8080";

// Patient
function addPatient(e) {
  e.preventDefault();
  let patient = {
    name: document.getElementById("patientName").value,
    age: document.getElementById("patientAge").value,
    disease: document.getElementById("patientDisease").value
  };

  fetch(BASE_URL + "/patients", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(patient)
  })
  .then(res => res.json())
  .then(data => {
    document.getElementById("patientOutput").innerText = JSON.stringify(data, null, 2);
  })
  .catch(err => {
    document.getElementById("patientOutput").innerText = "❌ Error: " + err;
  });
}

// Doctor
function addDoctor(e) {
  e.preventDefault();
  let doctor = {
    name: document.getElementById("doctorName").value,
    department: document.getElementById("doctorDept").value,
    specialization: document.getElementById("doctorSpec").value
  };

  fetch(BASE_URL + "/doctors", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(doctor)
  })
  .then(res => res.json())
  .then(data => {
    document.getElementById("doctorOutput").innerText = JSON.stringify(data, null, 2);
  })
  .catch(err => {
    document.getElementById("doctorOutput").innerText = "❌ Error: " + err;
  });
}

// Appointment
function bookAppointment(e) {
  e.preventDefault();
  let appointment = {
    patientId: document.getElementById("apptPatientId").value,
    doctorId: document.getElementById("apptDoctorId").value,
    date: document.getElementById("apptDate").value,
    time: document.getElementById("apptTime").value
  };

  fetch(BASE_URL + "/appointments", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(appointment)
  })
  .then(res => res.json())
  .then(data => {
    document.getElementById("apptOutput").innerText = JSON.stringify(data, null, 2);
  })
  .catch(err => {
    document.getElementById("apptOutput").innerText = "❌ Error: " + err;
  });
}

// Department
function addDepartment(e) {
  e.preventDefault();
  let dept = {
    name: document.getElementById("deptName").value
  };

  fetch(BASE_URL + "/departments", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(dept)
  })
  .then(res => res.json())
  .then(data => {
    document.getElementById("deptOutput").innerText = JSON.stringify(data, null, 2);
  })
  .catch(err => {
    document.getElementById("deptOutput").innerText = "❌ Error: " + err;
  });
}
