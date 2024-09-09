document.querySelectorAll('nav ul li a').forEach(anchor => {
    anchor.addEventListener('click', function(e) {
        e.preventDefault();
        document.querySelector(this.getAttribute('href')).scrollIntoView({
            behavior: 'smooth'
        });
    });
});


document.querySelectorAll('.course-item, .featured-course-item').forEach(item => {
    item.addEventListener('mouseenter', function() {
        this.style.transform = 'scale(1.05)';
    });
e
    item.addEventListener('mouseleave', function() {
        this.style.transform = 'scale(1)';
    });
});


const newsletterForm = document.querySelector('#newsletter form');
newsletterForm.addEventListener('submit', function(e) {
    const emailInput = newsletterForm.querySelector('input[type="email"]');
    const emailValue = emailInput.value.trim();

    if (!validateEmail(emailValue)) {
        e.preventDefault();
        alert('Please enter a valid email address.');
    }
});

function validateEmail(email) {
    const re = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return re.test(String(email).toLowerCase());
}


document.querySelector('.intro button').addEventListener('click', function() {
    alert('Redirecting to courses...');
});


document.querySelectorAll('.featured-course-item button').forEach(button => {
    button.addEventListener('click', function() {
        alert('Course details coming soon...');
    });
});
