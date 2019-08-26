$(function () {
    syncChkStatus()
    $('input[type="submit"]').click(validateForm)

    function validateForm(event) {
        const chbxId = $(event.target).data('chbx')
        const $chbx = $('#' + chbxId)
        if ($chbx.prop('checked')) { return true }
        if (! validateComment($chbx)) {
            event.preventDefault();
            alert('Need reason to reject')
            return false
        }
        return true
    }

    function validateComment($checkbox) {
        const commentId = $checkbox.data('comment')
        const $comment = $('#' + commentId)
        const commentContent  = $.trim($comment.val())
        const hasValue = Boolean(commentContent)
        if (!hasValue) {
            $comment.focus()
        }
        return hasValue
    }

    function syncChkStatus() {
        const $checkboxes = $('.chkStatus')
        for (let i = 0; i < $checkboxes.length; ++i) {
            const $chbx = $checkboxes.eq(i)
            // Get the checked radio with name = checkbox ID
            const id = $chbx.attr('id')
            const $radio = $(`input[for="${id}"]:checked`)
            const isActive = parseBool($radio.val())
            findCommentFor($chbx).prop('disabled', isActive)
            $chbx
                .prop('checked', isActive)
                .on('click', function(evt) {
                    const $this = $(evt.target)
                    const checked = $this.prop('checked')
                    $(`input[for="${id}"][value="${checked}"]`).prop('checked', true)
                    findCommentFor($this).prop('disabled', checked)
                })
        }
    }

    function parseBool(val) {
        return (val === 'true')
    }

    function findCommentFor($checkbox) {
        const commentId = $checkbox.data('comment')
        return $('#' + commentId)
    }
    // $('#chkStatus').click(function () {
    //     if ($(this).prop("checked") == true) {
    //         $("#true").prop("checked", true);
    //     } else if ($(this).prop("checked") == false) {
    //         $("#false").prop("checked", true);
    //     }
    // });
})
