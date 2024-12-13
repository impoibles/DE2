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
        error.style.left = "250px";
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

            // Регулярные выражения
            const onlyLettersRegex = /^[A-Za-zА-Яа-яЁё\s]+$/; // Разрешенные пробелы
            const onlyDigitsRegex = /^[0-9]+$/;
            const invalidCharsRegex = /[^A-Za-zА-Яа-яЁё0-9\s]/; // Разрешенные пробелы

            // Проверка на недопустимые символы
            if (invalidCharsRegex.test(value)) {
                showError(this, "Используйте только буквы и цифры.");
            }
            // Проверка: нельзя использовать одновременно буквы и цифры
            else if (!onlyLettersRegex.test(value) && !onlyDigitsRegex.test(value)) {
                showError(this, "Нельзя одновременно использовать буквы и цифры.");
            }
            // Проверка на количество цифр (должно быть 11)
            else if (onlyDigitsRegex.test(value) && value.length !== 11) {
                showError(this, "Если вы вводите СНИЛС, то он должен состоять из 11 цифр.");
            }
            // Удаляем ошибку, если все условия выполнены
            else {
                removeError(this);
            }
        });
    });

});
