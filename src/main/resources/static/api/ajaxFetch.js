/**
 *
 */
function handleAddProduct(event)
{
    event.preventDefault();
    fire_ajax();
}
function  fire_ajax()
{
    $.ajax({
        type: "GET",
        url: "/addProduct",
        processData: false,// prevent jQuery from automatically
        // transforming the data into a query string
        contentType: false,
        cache: false,
        timeout: 600000,
        success: function (data) {
             $("#app").empty();
             $("#app").append(data);
        },
        error: function (e) {

            console.log("ERROR : ", e);

        }
    });
}