var fetch = true;
var url = 'someurl.java';
$.ajax(
{
    // Post the variable fetch to url.
    type : 'post',
    url : url,
    dataType : 'json', // expected returned data format.
    data : 
    {
        'fetch' : fetch // You might want to indicate what you're requesting.
    },
    success : function(data)
    {
        // This happens AFTER the backend has returned an JSON array (or other object type)
        var res1, res2;

        for(var i = 0; i < data.length; i++)
        {
            // Parse through the JSON array which was returned.
            // A proper error handling should be added here (check if
            // everything went successful or not)

            res1 = data[i].res1;
            res2 = data[i].res2;

            // Do something with the returned data
            $('#div1').html(res1);
        }
    },
    complete : function(data)
    {
        // do something, not critical.
    }
});

setTimeout(foo, 30000);

setInterval(function()
{
    alert("hi");
}, 30000);
