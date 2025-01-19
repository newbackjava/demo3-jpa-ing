(function($) {
    'use strict'; // Start of use strict
    /*------------------------------------------------------------------
        Header Navigation
    ------------------------------------------------------------------*/
    var windowSize = $(window).width();

    if (windowSize >= 767) {
        $('ul.nav li.dropdown').hover(function() {
            $(this).find('.dropdown-menu').stop(true, true).delay(200).fadeIn(500);
        }, function() {
            $(this).find('.dropdown-menu').stop(true, true).delay(200).fadeOut(500);
        });
    }
	
	/*------------------------------------------------------------------
    Count Down
    ------------------------------------------------------------------*/
    if ($(".count-down").length) {
        var year = parseInt($(".count-down").attr("data-countdown-year"), 10);
        var month = parseInt($(".count-down").attr("data-countdown-month"), 3) - 1;
        var day = parseInt($(".count-down").attr("data-countdown-day"), 10);
        $(".count-down").countdown({
            until: new Date(year, month, day),
            padZeroes: true
        });
    }
    /*------------------------------------------------------------------
    	Scrool Top
    ------------------------------------------------------------------*/
    $.scrollUp({
        scrollText: '<i class="fa fa-angle-up"></i>',
        easingType: 'linear',
        scrollSpeed: 900,
        animation: 'fade'
    });
    /*------------------------------------------------------------------
        Loader
    ------------------------------------------------------------------*/
  
        $("#dvLoading").fadeOut("fast");
	
	  // map zooming 	
		$('.google-map').on('click', function() {
            $('.google-map').find('iframe').css("pointer-events", "auto");
        });
	/*------------------------------------------------------------------
    	Header Search
    ------------------------------------------------------------------*/
    $("#search-form").hide();
    $(".fa-search").on('click', function() {
        $("#search-form").toggle();
        $("#search-form").fadeIn().addClass("open");
    });
    $("#search-form .close").on('click', function() {
        $("#search-form").fadeOut().removeClass("open");
        $("#this").hide();
    });
	
    /*------------------------------------------------------------------
    Owl Carousel for screenshots
	------------------------------------------------------------------*/
    var owl = $("#screenshots");
    owl.owlCarousel({
        nav: true,
        margin: 10,
        loop: true,
        responsive: {
            0: {
                items: 1
            },
            450: {
                items: 2
            },
            600: {
                items: 3
            },
            700: {
                items: 3
            },
            1000: {
                items: 4
            },
            1200: {
                items: 4
            },
            1400: {
                items: 4
            },
            1600: {
                items: 4
            }
        }
    });
	/*------------------------------------------------------------------
    FAQ
    ------------------------------------------------------------------*/
    $('.panel-heading a').on('click', function() {
        $('.panel-heading').removeClass('active');
        $(this).parents('.panel-heading').addClass('active');
    });
	 /*------------------------------------------------------------------
        Animation Numbers
    ------------------------------------------------------------------*/
    jQuery('.animateNumber').each(function() {
        var num = jQuery(this).attr('data-num');

        var top = jQuery(document).scrollTop() + (jQuery(window).height());
        var pos_top = jQuery(this).offset().top;
        if (top > pos_top && !jQuery(this).hasClass('active')) {
            jQuery(this).addClass('active').animateNumber({
                number: num
            }, 2000);
        }
    });
    /*------------------------------------------------------------------
    Owl Carousel for Testimonials
	------------------------------------------------------------------*/
    var owl = $("#testimonials");
    owl.owlCarousel({
        nav: true,
        margin: 10,
        loop: true,
        responsive: {
            0: {
                items: 1
            },
            450: {
                items: 1
            },
            600: {
                items: 2
            },
            700: {
                items: 2
            },
            1000: {
                items: 3
            },
            1200: {
                items: 3
            },
            1400: {
                items: 3
            },
            1600: {
                items: 3
            }
        }
    });
})(jQuery);

/*------------------------------------------------------------------
	WOW
------------------------------------------------------------------*/

wow = new WOW({
    animateClass: 'animated',
    offset: 100
});
wow.init();