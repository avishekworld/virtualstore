


<br><br><br>
<section class="footerSection">
<div class="row">
	THIS IS FOOTER
<!-- javascript -->
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<!-- this for review -->
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
//  Check Radio-box
    $(".rating input:radio").attr("checked", false);
    $('.rating input').click(function () {
        $(".rating span").removeClass('checked');
        $(this).parent().addClass('checked');
    });

    $('input:radio').change(
    function(){
        var userRating = "Your rating : "+this.value;
        $(".userSelected").text(userRating);
    }); 
});
</script>
</div>
</section>
</html>