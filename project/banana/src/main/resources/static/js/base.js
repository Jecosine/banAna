/*
 * @Date: 2020-08-27 01:58:14
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-08-27 02:06:44
 */
var reachTop = true;

window.onscroll = () => {
    // console.log(window.scrollY);

    if(window.scrollY == 0)
    {
        console.log("to top event");
        let event = document.createEvent('HTMLEvents');
        event.initEvent("totop", false, true);
        window.dispatchEvent(event);
        reachTop = true;
        // that.$emit("to-top", '1');

        // $("#navigation-mask").stop().animate({opacity: 0}, 200);
    }
    else
    {
        if(reachTop)
        {
            console.log("leave top event");

            let event = document.createEvent('HTMLEvents');
            event.initEvent("leavetop", false, true);
            window.dispatchEvent(event);
            reachTop = false;
        }
        // this.$emit("scrollleavetop");
        // $("#navigation-mask").stop().animate({opacity: 1}, 200);
    }

}
// login simulation
var user = {
    'userName': 'jecosine',
    'expired': new Date(),
    'avatarUrl': '../static/img/avatar.jpg',
    'shopCart': {

    }
}