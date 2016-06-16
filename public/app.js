$(document).ready(function() {
  vespaPage.init();
})

var vespaPage  = {
  init: function() {
    vespaPage.events()
    vespaPage.styling()
  },

  styling: function() {
    vespaPage.read();
  },

  events: function() {
    $('form').on('submit', function(event) {
      event.preventDefault();
      var objToSave = {
        description: $('input[name="desc"]').val(),
        lat: $('input[name="lat"]').val(),
        lon: $('input[name="lon"]').val(),
        time: 0,
        hasSidecar: true,
        image: $('input[name="image"]').val(),
      }

      vespaPage.create(JSON.stringify(objToSave));

      $('input').val("");
    })
  },

  create: function(vespaObject) {
    $.post({
      contentType: "application/json; charset=utf-8",
      method: "POST",
      url: "/vespa",
      data: vespaObject,
      success: function(data) {
        console.log(data);
      },
      error: function(err) {
        console.error("OH SHIT, zach messed up", err);
      }
    })
  },

  read: function() {
    $.ajax({
      method: "GET",
      url: "/vespa",
      success: function(data) {
        console.log(data);
      },
      error: function(err) {
        console.error("OH SHIT, zach messed up", err);
      }
    })
  },
  update: function() {

  },

  destroy: function() {

  }
}
