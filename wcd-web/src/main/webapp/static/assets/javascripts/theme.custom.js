/* Toggle Full Screen Start */
function toggleFullscreen(elem) {
  elem = elem || document.documentElement;
  if (!document.fullscreenElement && !document.mozFullScreenElement &&
    !document.webkitFullscreenElement && !document.msFullscreenElement) {
    if (elem.requestFullscreen) {
      elem.requestFullscreen();
    } else if (elem.msRequestFullscreen) {
      elem.msRequestFullscreen();
    } else if (elem.mozRequestFullScreen) {
      elem.mozRequestFullScreen();
    } else if (elem.webkitRequestFullscreen) {
      elem.webkitRequestFullscreen(Element.ALLOW_KEYBOARD_INPUT);
    }
  } else {
    if (document.exitFullscreen) {
      document.exitFullscreen();
    } else if (document.msExitFullscreen) {
      document.msExitFullscreen();
    } else if (document.mozCancelFullScreen) {
      document.mozCancelFullScreen();
    } else if (document.webkitExitFullscreen) {
      document.webkitExitFullscreen();
    }
  }
}

document.getElementById('fullScreen_panel').addEventListener('click', function() {
  toggleFullscreen();
});

/* Toggle Full Screen End */

$('#sectionSelect').change(function(){
      $("#schemeSelect option").addClass("hidden");
      $("#schemeSelect option").removeAttr("selected");
      var sectionSelect = $("#sectionSelect").val();
      if (sectionSelect == "rural") {
        $("#schemeSelect option.rural").removeClass("hidden");
      }
      else if (sectionSelect == "NREGA") {
        $("#schemeSelect option.NREGA").removeClass("hidden");
      }
      else if (sectionSelect == "GGY") {
        $("#schemeSelect option.GGY").removeClass("hidden");
      }
      else if (sectionSelect == "OLM") {
        $("#schemeSelect option.OLM").removeClass("hidden");
      }
      else if (sectionSelect == "RURBAN") {
        $("#schemeSelect option.RURBAN").removeClass("hidden");
      }
      else if (sectionSelect == "SIRD") {
        $("#schemeSelect option.SIRD").removeClass("hidden");
      }
      else if (sectionSelect == "DWS") {
        $("#schemeSelect option.DWS").removeClass("hidden");
      }
      else if (sectionSelect == "CFC") {
        $("#schemeSelect option.CFC").removeClass("hidden");
      }
      else if (sectionSelect == "SFC") {
        $("#schemeSelect option.SFC").removeClass("hidden");
      }
    });

    $('#btnFilter').click(function(){
      var distSelect = $("#distSelect").val();
      var blockSelect = $("#blockSelect").val();
      var fySelect = $("#fySelect").val();
      var sectionSelect = $("#sectionSelect").val();
      var schemeSelect = $("#schemeSelect").val();
      if (sectionSelect == "rural" && schemeSelect == "nullVal" && distSelect == "nullVal" && blockSelect == "nullVal") {
        window.location.href = "su_sectionRural.html";
      }
      else if (distSelect == "Angul" && blockSelect == "Angul" && sectionSelect == "rural" && schemeSelect == "Titli") {
        window.location.href = "su_fullFilter.html";
      }
      else if (sectionSelect == "rural" && schemeSelect == "Titli" && distSelect == "nullVal" && blockSelect == "nullVal") {
        window.location.href = "su_schemeTitli.html";
      }
      else if (distSelect == "Angul" && blockSelect == "Angul" && sectionSelect == "nullVal" && schemeSelect == "nullVal") {
        window.location.href = "su_blockDashboard.html";
      }
      else if (distSelect == "Angul" && blockSelect == "nullVal" && sectionSelect == "nullVal" && schemeSelect == "nullVal") {
        window.location.href = "su_districtDashboard.html";
      }
      else if (sectionSelect == "NREGA" && schemeSelect == "nullVal" && distSelect == "nullVal" && blockSelect == "nullVal") {
        window.location.href = "su_sectionNREGA.html";
      }
    });


  $('#sectionSelect').change(function(){
      $("#sectionOtherCon").addClass("hidden");
      var sectionSelect = $("#sectionSelect").val();
      if (sectionSelect == "other") {
        $("#sectionOtherCon").removeClass("hidden");
      }
});








