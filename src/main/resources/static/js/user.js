document.addEventListener("DOMContentLoaded", function() {
    
    function showError(inputElement, message) {
        let error = inputElement.nextElementSibling;
        if (!error || !error.classList.contains("error-message")) {
            error = document.createElement("div");
            error.className = "error-message";
            inputElement.parentNode.insertBefore(error, inputElement.nextSibling);
        }
        error.textContent = message;
        error.style.position = "absolute";
        error.style.color = "red";
        error.style.top = "-20px";
        error.style.left = "360px";
    }

    
    function removeError(inputElement) {
        const error = inputElement.nextElementSibling;
        if (error && error.classList.contains("error-message")) {
            error.remove();
        }
    }

    
    const textInputs = document.querySelectorAll('input[type="text"]');
    
    textInputs.forEach(input => {
        input.addEventListener("input", function() {
            const value = this.value;
            const regex = /^[A-Za-zА-Яа-яЁё\s]*$/; 
            
            if (!regex.test(value)) {
                showError(this, "Пожалуйста, используйте только буквы.");
            } else {
                removeError(this);
            }
        });
    });


    const numberInput = document.getElementById("Snils");
    const validateSnils = () => {
        const value = numberInput.value;
        const isValid = /^(\d{11})$/.test(value); 

        if (!isValid) {
            showError(numberInput, "СНИЛС должен содержать 11 неотрицательных цифр.");
        } else {
            removeError(numberInput);
        }
    };

    numberInput.addEventListener("input", validateSnils);
    numberInput.addEventListener("focusout", validateSnils);
});
