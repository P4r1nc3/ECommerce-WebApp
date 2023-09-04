/**
 *
 */
function handleClick(event)
{
    event.preventDefault();
    fire_ajax();
}
function  fire_ajax()
{
    $.ajax({
        type: "GET",
        url: "/fetchExample",
        processData: false,// prevent jQuery from automatically
        // transforming the data into a query string
        contentType: false,
        cache: false,
        timeout: 600000,
        success: function (data) {
             $("#insert").append(data);
        },
        error: function (e) {

            console.log("ERROR : ", e);

        }
    });
}