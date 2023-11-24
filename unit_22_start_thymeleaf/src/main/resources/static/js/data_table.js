$(document).ready(function() {
    $('#selectSize').change(function(){
        let pageSize = $(this).find("option:selected").attr('value');
        let pageData = document.getElementById('pageData');
        const sortBy = pageData.getAttribute('data-sort-by');
        const sortType = pageData.getAttribute('data-sort-type');
        submitRequest(sortBy, sortType, 1, pageSize)
    });
});

function runPagination(currentPage) {
    let pageData = document.getElementById('pageData');
    const sortBy = pageData.getAttribute('data-sort-by');
    const sortType = pageData.getAttribute('data-sort-type');
    const pageSize = pageData.getAttribute('data-page-size');
    submitRequest(sortBy, sortType, currentPage, pageSize)
}

function submitRequest(sortBy, sortType, currentPage, pageSize) {
    let data_table_employee_submit = document.getElementById('data_table_employee_submit');
    if (data_table_employee_submit !== null) {
        let data_table_employee = document.getElementById('data_table_employee');
        if (data_table_employee !== null) {
            let input = document.createElement("input");
            input.setAttribute("type", "hidden");
            input.setAttribute("name", "sortBy");
            input.setAttribute("value", sortBy);
            data_table_employee.appendChild(input);
            input = document.createElement("input");
            input.setAttribute("type", "hidden");
            input.setAttribute("name", "sortType");
            input.setAttribute("value", sortType);
            data_table_employee.appendChild(input);
            input = document.createElement("input");
            input.setAttribute("type", "hidden");
            input.setAttribute("name", "currentPage");
            input.setAttribute("value", currentPage);
            data_table_employee.appendChild(input);
            input = document.createElement("input");
            input.setAttribute("type", "hidden");
            input.setAttribute("name", "pageSize");
            input.setAttribute("value", pageSize);
            data_table_employee.appendChild(input);
            data_table_employee_submit.click();
        }
    }
}