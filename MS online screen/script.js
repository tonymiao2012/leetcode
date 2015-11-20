$(document).ready(function(){
  var aboveHeight = $('header').outerHeight();
  $(window).scroll(function(){
    if($(window).scrollTop() > aboveHeight){
      $('nav').addClass('fixed');
    }else{
      $('nav').removeClass('fixed');
    }
  });
  $("article.sub-story").click(function(){
    $(".main-story").fadeOut('slow');
    $('#sub-article').fadeOut('slow');
    $('#sub-article').slideDown('slow');
  });
});

