$(document).ready(function() {

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

  },

  create: function(vespaObject) {
    $.ajax({
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
